package javierarrieta.circe

import io.circe._
import io.circe.generic.encoding.DerivedObjectEncoder
import io.circe.generic.semiauto._
import shapeless.Lazy
import shapeless.tag.@@

object data {
  sealed trait EmailAddressTag
  sealed trait PasswordTag
  type EmailAddress = String @@ EmailAddressTag
  type Password = String @@ PasswordTag

  final case class CustomerRegistrationEntity(email: EmailAddress, password: Password)

}

object codecs {
  import data._

  implicit val emailEncoder: Encoder[EmailAddress] = Encoder.encodeString.contramap(identity)
  implicit val passwordEncoder: Encoder[Password] = Encoder.encodeString.contramap(identity)

  implicit val encodeCustomerRegistrationEntity: Encoder[CustomerRegistrationEntity] =
    deriveEncoder(Lazy.mkLazy[DerivedObjectEncoder[CustomerRegistrationEntity]])
}
