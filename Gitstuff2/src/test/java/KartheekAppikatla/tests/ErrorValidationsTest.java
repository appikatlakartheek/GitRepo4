package KartheekAppikatla.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import KartheekAppikatla.testcomponents.BaseTest;
import KartheekAppikatla.testcomponents.Retry;
import KartheekAppikatla.PageObjects.LandingPage;
//import KartheekAppikatla.pageobjects.CartPage;
//import KartheekAppikatla.pageobjects.CheckoutPage;
//import KartheekAppikatla.pageobjects.ConfirmationPage;
//import KartheekAppikatla.pageobjects.ProductCatalogue;







public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {


		landingPage.loginToApplication("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email or password.", LandingPage.getErrorMessage());

	}
	

//	@Test
//	public void ProductErrorValidation() throws IOException, InterruptedException
//	{
//
//		String productName = "ZARA COAT 3";
//		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
//		List<WebElement> products = productCatalogue.getProductList();
//		productCatalogue.addProductToCart(productName);
//		CartPage cartPage = productCatalogue.goToCartPage();
//		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
//		Assert.assertFalse(match);
//		
//	
//
//	}

	
	

}
