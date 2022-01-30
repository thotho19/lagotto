package io.github.binaryfoo.lagotto

object Iso8583 {

  def invertMTI(mti: String): String = {
    if (mti.length == 4) {
      if (isResponseMTI(mti))
        toRequestMti(mti)
      else
        toResponseMti(mti)
    } else {
      mti
    }
  }

  def isResponseMTI(mti: String): Boolean = mti(2).toInt % 2 == 1

  def isRequestMTI(mti: String): Boolean = mti(2).toInt % 2 == 0

  def toRequestMti(mti: String): String = {
    val characters = mti.toCharArray
    characters(2) = (mti(2).toInt - 1).toChar
    new String(characters)
  }

  def toResponseMti(mti: String): String = {
    val characters = mti.toCharArray
    characters(2) = (mti(2).toInt + 1).toChar
    new String(characters)
  }

}
