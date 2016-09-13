import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Job {
  private String mTitle;
  private String mCompany;
  private String mDescription;
  private String mStartDate;
  private String mEndDate;


  public Job(String title, String company, String description, String startDate, String endDate) {
    mTitle = title;
    mCompany = company;
    mDescription = description;
    mStartDate = startDate;
    mEndDate = endDate;
  }

  public String calculateElapse(){
    String [] start = mStartDate.split("-");
    String [] end = mEndDate.split("-");
    LocalDate startDate =  LocalDate.of(Integer.parseInt(start[0]),Integer.parseInt(start[1]),Integer.parseInt(start[2]));
    LocalDate endDate =  LocalDate.of(Integer.parseInt(end[0]),Integer.parseInt(end[1]),Integer.parseInt(end[2]));
    Period elapse = Period.between(startDate,endDate);
    if(elapse.getYears()<1){
        return "Months: " + elapse.getMonths();

    }else{
      return "Years: "+ elapse.getYears() + " Months: " + elapse.getMonths();
    }
  }

  public String getTitle() {
    return mTitle;
  }

  public String getCompany() {
    return mCompany;
  }

  public String getDescription() {
    return mDescription;
  }


  public String formatDate(String dateType){
    String [] dateArray = dateType.split("-");
    String date = dateArray[1]+"/"+dateArray[2]+"/"+dateArray[0];
    return date;
  }

  public String getStartDate() {
    return mStartDate;
  }

  public String getEndDate() {
    return mEndDate;
  }

}
