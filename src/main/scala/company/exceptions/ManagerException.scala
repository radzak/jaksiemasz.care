package company.exceptions

case class ManagerException(private val message: String = "",
                           private val cause: Throwable = None.orNull)
  extends Exception(message, cause)
