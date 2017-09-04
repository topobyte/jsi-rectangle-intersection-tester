package de.topobyte.jsi.intersectiontester;

import org.junit.Assert;
import org.junit.Test;

import com.infomatiq.jsi.Rectangle;

public class TestConstructorWithRTree
{

	@Test
	public void testEmpty()
	{
		RTreeIntersectionTester tester1 = new RTreeIntersectionTester();

		RTreeIntersectionTester tester2 = new RTreeIntersectionTester(
				tester1.tree);

		Assert.assertEquals("internal id counter", tester1.counter,
				tester2.counter);
	}

	@Test
	public void testSome()
	{
		RTreeIntersectionTester tester1 = new RTreeIntersectionTester();

		tester1.add(new Rectangle(1, 1, 2, 2), false);
		tester1.add(new Rectangle(3, 1, 4, 2), false);

		RTreeIntersectionTester tester2 = new RTreeIntersectionTester(
				tester1.tree);

		Assert.assertEquals("internal id counter", tester1.counter,
				tester2.counter);
	}

}
