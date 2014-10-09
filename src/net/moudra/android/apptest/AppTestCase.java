package net.moudra.android.apptest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AppTestCase extends UiAutomatorTestCase {

	public void testApp() throws UiObjectNotFoundException {

		//Home Screen
		getUiDevice().pressHome();

		UiObject appsButton = new UiObject(new UiSelector().description("Apps"));
		appsButton.clickAndWaitForNewWindow();

		//Apps Screen
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();

		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));

		appViews.setAsHorizontalList();

		UiObject calculatorApp = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()),
				"Calculator");
		calculatorApp.clickAndWaitForNewWindow();

		//Calculator app
		UiObject threeButton = new UiObject(new UiSelector().text("3"));
		threeButton.click();

		UiObject plusButton = new UiObject(new UiSelector().text("+"));
		plusButton.click();

		UiObject fiveButton = new UiObject(new UiSelector().text("5"));
		fiveButton.click();

		UiObject equalsButton = new UiObject(new UiSelector().text("="));
		equalsButton.click();

		UiObject display = new UiObject(
				new UiSelector()
						.resourceId("com.android.calculator2:id/display"));
		UiObject displayNumber = display.getChild(new UiSelector().index(0));

		assertEquals(displayNumber.getText(), "8");

		sleep(3000);
		getUiDevice().pressBack();

		//Apps Screen
		UiObject browserApp = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()), "Browser");
		browserApp.clickAndWaitForNewWindow();

		//Browser App
		UiObject urlForm = new UiObject(
				new UiSelector().resourceId("com.android.browser:id/url"));
		urlForm.setText("http://www.gug.cz");
		getUiDevice().pressEnter();

		sleep(10000);

		UiObject moreButton = new UiObject(
				new UiSelector().resourceId("com.android.browser:id/more"));
		moreButton.click();

		sleep(1000);
		UiObject refreshButton = new UiObject(new UiSelector().text("Refresh"));
		refreshButton.click();
	}
}
