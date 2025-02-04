package Expedia.FlightsBookingTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import browserFactory.BaseClassBrowserSetUp;
import utilities.DataReaderClass;

public class FlightBookingTest extends BaseClassBrowserSetUp {

private static final Logger log = LogManager.getLogger(FlightBookingTest.class);
  @Test
  public void flightBookingTest() throws InterruptedException {
	  log.info("Flight Booking Test Initialized");
	  landingpage.enterFlightInfo(DataReaderClass.getData(0, 0, 0),DataReaderClass.getData(0, 0, 1));
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}