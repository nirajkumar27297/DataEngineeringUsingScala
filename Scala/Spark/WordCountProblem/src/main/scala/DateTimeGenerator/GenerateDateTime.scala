package DateTimeGenerator

import java.text.SimpleDateFormat
import java.util.Calendar

class GenerateDateTime extends GenerateDateTimeTrait {

  def generateTimeDDMMYYFormat(): String = {
    val today = Calendar.getInstance().getTime()
    val form = new SimpleDateFormat("dd-MM-yy")
    val hr24 = new SimpleDateFormat("HH")
    val formhr24 = hr24.format(today.getTime)
    val min = new SimpleDateFormat("mm")
    val formmin = min.format(today.getTime)
    val sec = new SimpleDateFormat("ss")
    val formsec = sec.format(today.getTime)
    val time  = (form.format(today)+","+formhr24+":"+formmin+":"+formsec).toString
    time
  }

}
