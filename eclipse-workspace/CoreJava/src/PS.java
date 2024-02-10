import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
public void doThis()
{
	System.out.println("Inheritance");
	
	}
@BeforeMethod
public void beforeRun()
{
	System.out.println("First executed");
}

@AfterMethod
public void AfterRun()
{
	System.out.println("Last executed");
}
}
