package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import io.cucumber.java.en.When;

public class PostMarket1 extends BaseClass  {
	
	
	
	@When("User Click the Watch List")
	public void user_click_the_watch_list() throws InterruptedException {
		Thread.sleep(4000);
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement element = driver
				.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
		
		Actions f=new Actions(driver);
		f.moveToElement(element).perform();
		f.click(element).perform();
		Thread.sleep(2000);
		
	}

	@When("User Select scrip {string}")
	public void user_select_scrip(String string) throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='select-box active']//descendant::li//span[text()='"+string+"']"))
				.click();
		System.out.println(string);
		Thread.sleep(4000);
	}

	@When("User Click Watch List Again")
	public void user_click_watch_list_again() throws InterruptedException {
		WebElement element1 = driver
				.findElement(By.xpath("(//div[@class='header-left']//descendant::span[@class='ind_syml'])[1]"));
		element1.click();

		Thread.sleep(2000);
	}

	@When("User mouse over the scrip {string}")
	public void user_mouse_over_the_scrip(String string) throws InterruptedException {
		
		Thread.sleep(2000);Thread.sleep(2000);
		WebElement contractSelectAgain = driver.findElement(
				By.xpath("//div[@class='select-box active']//descendant::li//span[text()='" + string + "']"));

		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		ac.moveToElement(contractSelectAgain).perform();
		
		driver.findElement(By.xpath("(//span[@data-symbol='"+string+"'])[2]")).click();

		Thread.sleep(2000);
		
	}

	@When("User Click the Charts")
	public void user_click_the_charts() throws InterruptedException {
		Thread.sleep(2000);
		WebElement charts = driver.findElement(By.xpath(
				"//div[@class='select-box active']//descendant::span[text()='NIFTY 50']//ancestor::li//descendant::img"));
		charts.click();

		Thread.sleep(3000);
	}
	
	@When("User Click the {string} Charts")
	public void user_click_the_charts(String string) throws InterruptedException {
	    
		Thread.sleep(2000);
		WebElement charts = driver.findElement(By.xpath(
				"//div[@class='select-box active']//descendant::span[text()='Nifty 50']//ancestor::li//descendant::span[@class='ind_chart_btn']"));
		charts.click();

		Thread.sleep(3000);
		
	}

	@When("User Click the Candles Icon")
	public void user_click_the_candles_icon() throws InterruptedException {
		WebElement firstiFrame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));

		driver.switchTo().frame(firstiFrame);

		Thread.sleep(3000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Financial Chart']"));

		driver.switchTo().frame(iframe);

		driver.findElement(By.xpath("//div[@id='header-toolbar-chart-styles']")).click();
		Thread.sleep(3000);
	}

	@When("User Choose Candle {string}")
	public void user_choose_candle(String string) throws InterruptedException {
		driver.findElement(By.xpath("//div[@data-value='" + string + "']")).click();
		Thread.sleep(2000);
	}

	@When("User Click the Mintues")
	public void user_click_the_mintues() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();
		Thread.sleep(2000);

	}

	@When("User Choose One Minute")
	public void user_choose_one_minute() {
		driver.findElement(By.xpath("//div[text()='1 minute']//ancestor::div[@data-value='1']")).click();

	}

	@When("Verify One Minute Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_minute_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
			throws InterruptedException {
		WebElement element3 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text2 = element3.getText();
		System.err.println("Feed Connection Value of One Minute : " + text2);

		Thread.sleep(60000);

		System.out.println("Feed Connection Value of After One Minute : " + text2);

	}

	@When("User Click the Five Minute")
	public void user_click_the_five_minute() {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='5 minutes']//ancestor::div[@data-value='5']")).click();

	}

	@When("Verify Five Minute Feed Connection Valuebb")
	public void verify_five_minute_feed_connection_value() throws InterruptedException {
		WebElement element2 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text = element2.getText();
		System.err.println("Feed Connection Value of Five Minutes : " + text);

	}

	@When("User Click One Day")
	public void user_click_one_day() {
		driver.findElement(By.xpath("//div[@id='header-toolbar-intervals']")).click();

		driver.findElement(By.xpath("//div[text()='1 day']//ancestor::div[@data-value='1D']")).click();

	}

	@When("Verify One Day Feed Connection Value and Wait One Minute Very Feed Connection Changes")
	public void verify_one_day_feed_connection_value_and_wait_one_minute_very_feed_connection_changes()
			throws InterruptedException {

		WebElement element4 = driver.findElement(By.xpath(
				"/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/table/tr[1]/td[2]/div/div[2]/div[1]/div/div[2]/div/div[5]/div[2]"));
		Thread.sleep(4000);
		String text3 = element4.getText();
		System.err.println("Feed Connection Value of 1 hour : " + text3);
		Thread.sleep(60000);

		System.err.println("Feed Connection Value of 1 hour and 1 mins: " + text3);

	}
	
	
	@When("User click the search box")
	public void user_click_the_search_box() throws InterruptedException {
		Thread.sleep(4000);

		 driver.findElement(By.xpath("//input[@id='project-id']")).click();
		Thread.sleep(3000);
	}

	@When("User Search any {string} Script")
	public void user_search_any_script(String string) throws InterruptedException {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
	}

	@When("User Mouse Over and Add a Script {string}")
	public void user_mouse_over_and_add_a_script(String string) throws InterruptedException {
		Thread.sleep(3000);

		// //tagname[contains(text(), 'value')]
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//ancestor::li"));

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//ancestor::li//descendant::span[@class='s_add_sym']")).click();
	}

	
	@When("User POP Up Message Appear Verify POP UP")
	public void user_pop_up_message_appear_verify_pop_up() throws InterruptedException {

//		WebElement popUp = driver.findElement(By.xpath("//span[text()='Symbol Has been Added Successfully']"));
//
//		if (popUp.isDisplayed()) {
//
//			System.out.println("Verify Pop is Displayed Successfully");
//		} else {
//			System.out.println("Verify Pop is Not Displayed ");
//
//		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Clear']")).click();

	}
	
	@When("User Mouse Over and Add a Script")
	public void user_mouse_over_and_add_a_script() throws InterruptedException {
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//div[@class='srh_results act']/descendant::li[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='srh_results act']/descendant::span[@class='s_add_sym'])[1]"))
				.click();
	}
	
	@When("User Remove The {string} Stock")
	public void user_remove_the_stock(String string) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//parent::div"));

		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//following-sibling::span")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()=' Delete']")).click();
		Thread.sleep(2000);

	}
	
	@When("User Click The Withdraw button")
	public void user_click_the_withdraw_button() throws InterruptedException {

		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='funds_show']")).click();
		
		

		driver.findElement(By.xpath("(//div[@class='nav_btns']//child::button[text()='Withdraw'])[1]")).click();
		Thread.sleep(4000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter amount']")).sendKeys("1");
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='bank_radio']"));
		Thread.sleep(2000);
		
        if (element.isDisplayed()) {
        	
        	String blue = "\u001B[34m";
        	
        	System.out.println(blue + "Bank Deatails is displayed");
			
			
		} 
		
		else {
			System.err.println("Bank Details is not displayed");

		}
        Thread.sleep(2000);
        
        driver.switchTo().defaultContent();
		
        Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title1='Dashboard']/parent::li")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//span[@class='funds_back'])[2]")).click();

	}

	
	@When("User Click Add Money")
	public void user_click_add_money() throws InterruptedException {
		Thread.sleep(4000);

		WebElement element = driver.findElement(
				By.xpath("//button[@data-dhx-id='btn_addmoney']"));
		element.click();

	}

	@When("User enter money in amount to add")
	public void user_enter_money_in_amount_to_add() throws InterruptedException {
		Thread.sleep(4000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		        By.xpath("//iframe[contains(@class,'iframe_window')]")
		));

		System.out.println("Switched to iframe successfully");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Amount']")).click();

		WebElement enterAmount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));
		enterAmount.clear();
		Thread.sleep(1000);

		enterAmount.sendKeys("50");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='deposit_amount']")).click();
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
	}

	@When("User Choose Pay Using UPI")
	public void user_choose_pay_using_upi() throws InterruptedException {
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> li1 = new ArrayList<String>(windowHandles1);
		int size = li1.size();
		System.out.println(size);

		driver.switchTo().window(li1.get(1));

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		driver.navigate().refresh();

		Thread.sleep(5000);

	}

	@When("User Enter UPI\\/ID\\/Mobile Number and click pay now")
	public void user_enter_upi_id_mobile_number_and_click_pay_now() throws InterruptedException, AWTException {
		driver.switchTo().frame(0);

		//Robot robot = new Robot();

		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0, -500)");

		WebElement netBanking = driver.findElement(By.xpath("//input[@placeholder='example@okhdfcbank']"));

		netBanking.click();
		Thread.sleep(1000);

		WebElement UPI = driver.findElement(By.xpath("//input[@placeholder='example@okhdfcbank']"));

		UPI.sendKeys("6374837965");
		Thread.sleep(1000);

		WebElement clickPayUsingUPI = driver.findElement(By.xpath("//button[text()='Verify and Pay']"));
		clickPayUsingUPI.click();

		Thread.sleep(3000);

		
		WebElement clickPayUsingUPI1 = driver.findElement(By.xpath("//button[text()='Cancel Payment']"));
		clickPayUsingUPI1.click();
		
		WebElement clickPayUsingUPI11 = driver.findElement(By.xpath("//button[@data-testid='confirm-positive']"));
		clickPayUsingUPI11.click();
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, java.time.Duration.ofMinutes(1));
		WebElement rejectedMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Payment could not be completed']")));
	//	WebElement rejectedMessage = driver.findElement(By.xpath("//div[text()='Payment could not be completed']"));

		if (rejectedMessage.isDisplayed()) {
			js.executeScript("arguments[0].style.border='2px solid yellow'", rejectedMessage);
			System.err.println("Payment Declined");

		}

		else {
			js.executeScript("arguments[0].style.border='2px solid red'", rejectedMessage);
			System.err.println("Payment SuccessFul");
		}

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

	}
	
	
	

	@When("User Search {string} in Searchbox")
	public void user_search_in_searchbox(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id='project-id']")).click();
		
		driver.findElement(By.xpath("//input[@id='project-id']")).sendKeys(string);
		Thread.sleep(3000);
	}

	@When("User Click Futures")
	public void user_click_futures() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[2]")).click();
			
		} catch (Exception e) {
			
			driver.findElement(By.xpath("(//span[text()='Futures'])[1]")).click();
			
		}

		
		Thread.sleep(3000);

	}

	@When("User mouse over {string} and click add icon")
	public void user_mouse_over_and_click_add_icon(String string) throws InterruptedException {
		Thread.sleep(3000);

		WebElement element = driver
				.findElement(By.xpath("(//span[contains(text(),'"+string+"')]//parent::div//child::span[@class='symbolsseries'])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//span[contains(text(),'"+string+"')]//ancestor::li//descendant::span[@class='s_add_sym'])[1]"))
				.click();

	}

	@When("Symbol Has been Added Successfully Notification Shown")
	public void symbol_has_been_added_successfully_notification_shown() {

//		WebElement notification = driver.findElement(By.xpath("//span[text()='Symbol Has been Added Successfully']"));
//	
//		WebElement alreadyAdded = driver.findElement(By.xpath("//span[text()='Token already exist']"));
//		if (notification.isDisplayed()) {
//			System.out.println("Verify Scrip Added Successfully");
//		} 
//
//		else {
//			System.out.println("error");
//		}

		System.out.println("hello");
	}

	@When("User Click Clear in search box")
	public void user_click_clear_in_search_box() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Clear']")).click();
	}

	@When("User Click {string}")
	public void user_click(String string) throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'"+string+"')]//following-sibling::span[@class='symbolsseries']"))
				.click();

	}

	@When("User Click F&O")
	public void user_click_f_o() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='s_more md_btn1']")).click();
	}

	@When("User Click Cancel button in Ready Made Pop up")
	public void user_click_cancel_button_in_ready_made_pop_up() throws InterruptedException {

		Thread.sleep(5000);

		
//		WebElement element = driver.findElement(By.xpath("(//span[text()='x'])[1]"));
//		driver.switchTo().frame(0);
//		
//		if (condition) {
//			
//		} else {
//
//		}

		
	}

	@When("User Click LTP")
	public void user_click_ltp() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement element2 = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		
		driver.switchTo().frame(element2);
		Actions d=new Actions(driver);

		WebElement element = driver.findElement(By.xpath("(//button[text()='LTP'])[1]"));
		Thread.sleep(2000);
		d.moveToElement(element).perform();
		d.click(element).perform();
		Thread.sleep(2000);
	}

	@When("User Verify the Fluctuating")
	public void user_verify_the_fluctuating() throws InterruptedException {

		WebElement callLTP = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[1]"));
		String text = callLTP.getText();
		System.out.println("Call LTP Value :" + text);

		Thread.sleep(5000);

		WebElement callLTP1 = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[1]"));
		String text1 = callLTP1.getText();
		System.out.println("Call LTP Value After 5 Second:" + text1);

		if (text.equalsIgnoreCase(text1)) {
			System.out.println("Verified Lpt Call LTP Values is not fluctuating");
		} else {
			System.out.println("Verified Lpt Call LTP Values is fluctuating");

		}
		///////////////////////////////

		WebElement putLTP = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[12]"));
		String text2 = putLTP.getText();
		System.out.println("Call LTP Value :" + text2);

		Thread.sleep(5000);

		WebElement putLTP1 = driver.findElement(
				By.xpath("(//div[@class='ops_ltp_item get_attr_data act_left act_right']//descendant::span)[12]"));
		String text3 = putLTP1.getText();
		System.out.println("Put LTP Value After 5 Second:" + text3);

		if (text2.equalsIgnoreCase(text3)) {
			System.out.println("Put Lpt LTP Values is not fluctuating");
		} else {
			System.out.println("Put Lpt LTP Values is fluctuating");

		}

	}

	
	@When("User Select any Call LTP Buy")
	public void user_select_any_call_ltp_buy() throws InterruptedException {

		Thread.sleep(2000);
		
		try {
			
			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
			
		} catch (Exception e) {
			
			System.out.println("Not Visiable Ready Mode Popup Showing");
		}
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//iframe[@class='iframe_window']"));
		driver.switchTo().frame(element);
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//button[text()='Buy/Sell']"));
		element2.click();
		Thread.sleep(1000);
		
		WebElement buy = driver.findElement(By.xpath(
				"(//div[@class='ops_bs_item get_attr_data act_left act_right']//descendant::span[@data-trade='B'])[1]"));
		buy.click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

	}

	@When("User Select any Put LTP Sell")
	public void user_select_any_put_ltp_sell() throws InterruptedException {
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath("//iframe[@id='strategy_builder']"));
		driver.switchTo().frame(element);
		Thread.sleep(1000);
		
		WebElement element2 = driver.findElement(By.xpath("//span[@class='ready_mode_close']"));
		
		if (element2.isDisplayed()) {
			
			driver.findElement(By.xpath("//span[@class='ready_mode_close']")).click();
			
		} else {

			System.err.println("Ready Mode Button Not Visiable");
		}
		
		Thread.sleep(1000);

		WebElement sell = driver.findElement(By.xpath(
				"(//div[@class='ops_bs_item get_attr_data act_left act_right']//descendant::span[@data-trade='S'])[2]"));
		sell.click();
		Thread.sleep(1000);

	}

	@When("User Click Save Strategy")
	public void user_click_save_strategy() throws InterruptedException {

		WebElement save = driver.findElement(By.xpath("//div[text()='Save Strategy']"));
		save.click();
		Thread.sleep(1000);

	}

	@When("User enter Strategy Name {string}")
	public void user_enter_strategy_name(String string) throws InterruptedException {
		Random random = new Random();

		// Generate a random long value representing milliseconds since epoch
		long randomEpochMilli = random.nextLong();

		// Convert the long value to a LocalDateTime object (Java 8 or later)
		LocalDateTime randomDateTime = Instant.ofEpochMilli(randomEpochMilli).atZone(ZoneId.systemDefault())
				.toLocalDateTime();

		// Format the LocalDateTime object
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = randomDateTime.format(formatter);

		// Print the formatted date time
		System.out.println("Random Date Time: " + formattedDateTime);
		WebElement strategyName = driver.findElement(By.xpath("//input[@id='stratagy_name']"));
		strategyName.sendKeys(string + formattedDateTime);
		Thread.sleep(1000);
	}

	@When("User Click Save")
	public void user_click_save() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//input[@value='Save']"));
		element.click();
		Thread.sleep(1000);

	}

	@When("User Click Strategy Message ok")
	public void user_click_strategy_message_ok() throws InterruptedException {

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']")).click();
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//span[@class='str_save_close']")).click();
		Thread.sleep(3000);
	}

	@When("User Click Place Order")
	public void user_click_place_order() throws InterruptedException {

		WebElement placeOrder = driver.findElement(By.xpath("//span[text()=' Place Order']"));
		//js.executeScript("arguments[0].click();", placeOrder);
		placeOrder.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()='yes']")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@class='jconfirm-buttons']//child::button[text()='ok']")).click();

	}

	@When("User click read made")
	public void user_click_read_made() throws InterruptedException {

		driver.findElement(By.xpath("//div[text()='Ready made']")).click();
		Thread.sleep(1000);

	}
	
	
	@When("User Choose Ready made Strategy categories {string}")
	public void user_choose_ready_made_strategy_categories(String string) throws InterruptedException {

		driver.findElement(By.xpath("//a[text()='" + string + "']")).click();
		Thread.sleep(1000);

	}

	@When("User Select Strategy under categories {string}")
	public void user_select_strategy_under_categories(String string) {

		driver.findElement(By.xpath("(//div[text()='" + string + "']//parent::div)[1]")).click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
