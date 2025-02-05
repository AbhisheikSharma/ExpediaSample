package Expedia.FlightsBookingTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import browserFactory.BaseClassBrowserSetUp;

public class FlightBookingTest extends BaseClassBrowserSetUp {

private static final Logger log = LogManager.getLogger(FlightBookingTest.class);
  @Test
  public void flightBookingTest() throws InterruptedException {
	  log.info("Flight Booking Test Initialized");
	  landingpage.enterFlightInfo(datareader.getData(0, 0, 0), datareader.getData(0, 0, 1));
}
}