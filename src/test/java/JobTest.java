import org.junit.*;
import static org.junit.Assert.*;

public class JobTest {
  @Test
  public void duration_returnDurationOfJob_13(){
    Job aJob = new Job("Teacher","School","taught","11/12/1994","05/12/1999");
    long expected = 13;
    assertEquals(expected,aJob.calculateElapse());
  }
}
