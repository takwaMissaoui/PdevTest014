package edu.esprit.tn.PdevTestunitaire014.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Pdev.Service.CurrencyServiceRemote;
import Pdev.entity.Currency;

public class Currencytest {

	CurrencyServiceRemote csr;

	@Before
	public void setUp() throws Exception {

		InitialContext init = new InitialContext();

		csr = (CurrencyServiceRemote) init
				.lookup("Pdev0/CurrencyService!Pdev.Service.CurrencyServiceRemote");

	}

	@Test
	public void testCurrencyService() {
		fail("Not yet implemented");
	}

	@Test
	public void testshouldUpdate() {

		Currency cur = csr.findBy("TND");
		cur.setIs_available(true);
		csr.update(cur);

	}

	@Test
	public void testshouldFindBy() {
		Currency cur = csr.findBy("€");
		Assert.assertEquals("€", cur.getId_currency());

	}

	@Test
	public void testshouldFindall() {
		List<Currency> curs = csr.findall();
		Assert.assertEquals(218, curs.size());

	}

	@Test
	public void testshouldFindAvailables() {
		List<Currency> curs = csr.findAvailables();
		Assert.assertEquals(1, curs.size());
	}

	@Test 
	public void Shouldsetlocal_currency(){
		
		Currency cl = csr.findBy("TND");
		csr.setlocal_currency(cl);
		Assert.assertEquals(true, cl.isIs_local_currency());
		
		
	}
}
