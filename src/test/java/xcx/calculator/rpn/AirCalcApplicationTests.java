package xcx.calculator.rpn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xcx.calculator.rpn.service.RpnProcessorService;
import xcx.calculator.rpn.service.display.DisplayService;

import java.math.BigDecimal;
import java.util.Stack;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirCalcApplicationTests{

	@Autowired
	private RpnProcessorService rpnProcessor;

	@Autowired
	private DisplayService displayService;

	@Before
	public void initStack(){
		rpnProcessor.setStack(new Stack<>());
		rpnProcessor.setOperationHistory(new Stack<>());
	}

	@Test
	public void testExample1() {
		String line = "5 2";
		Stack<BigDecimal> results = rpnProcessor.process(line);
		displayService.display(results);

		Assert.assertEquals(results.pop(),new BigDecimal(2));
		Assert.assertEquals(results.pop(),new BigDecimal(5));
	}

	@Test
	public void testExample2() {
		Stack<BigDecimal> results = rpnProcessor.process("2 sqrt");
		displayService.display(results);
		BigDecimal result = results.pop().setScale(10, BigDecimal.ROUND_DOWN);
		Assert.assertEquals(result,new BigDecimal("1.4142135623"));

		results = rpnProcessor.process("clear 9 sqrt");
		displayService.display(results);
		Assert.assertEquals(results.pop(),new BigDecimal("3"));
	}

	@Test
	public void testExample3() {
		Stack<BigDecimal> results = rpnProcessor.process("5 2 -");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(3));

		results = rpnProcessor.process("3 -");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(0));

		results = rpnProcessor.process("clear");
		displayService.display(results);
		Assert.assertTrue(results.isEmpty());
	}

	@Test
	public void testExample4() {
		Stack<BigDecimal> results = rpnProcessor.process("5 4 3 2");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("5")),4);
		Assert.assertEquals(results.search(new BigDecimal("4")),3);
		Assert.assertEquals(results.search(new BigDecimal("3")),2);
		Assert.assertEquals(results.search(new BigDecimal("2")),1);

		results = rpnProcessor.process("undo undo *");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(20));

		results = rpnProcessor.process("5 *");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(100));

		results = rpnProcessor.process("undo");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("20")),2);
		Assert.assertEquals(results.search(new BigDecimal("5")),1);
	}

	@Test
	public void testExample5() {
		Stack<BigDecimal> results = rpnProcessor.process("7 12 2 /");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("7")),2);
		Assert.assertEquals(results.search(new BigDecimal("6")),1);

		results = rpnProcessor.process("*");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(42));

		results = rpnProcessor.process("4 /");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(10.5));
	}

	@Test
	public void testExample6() {
		Stack<BigDecimal> results = rpnProcessor.process("1 2 3 4 5");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("1")),5);
		Assert.assertEquals(results.search(new BigDecimal("2")),4);
		Assert.assertEquals(results.search(new BigDecimal("3")),3);
		Assert.assertEquals(results.search(new BigDecimal("4")),2);
		Assert.assertEquals(results.search(new BigDecimal("5")),1);

		results = rpnProcessor.process("*");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("1")),4);
		Assert.assertEquals(results.search(new BigDecimal("2")),3);
		Assert.assertEquals(results.search(new BigDecimal("3")),2);
		Assert.assertEquals(results.search(new BigDecimal("20")),1);

		results = rpnProcessor.process("clear 3 4 -");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(-1));
	}

	@Test
	public void testExample7() {
		Stack<BigDecimal> results = rpnProcessor.process("1 2 3 4 5");
		displayService.display(results);
		Assert.assertEquals(results.search(new BigDecimal("1")),5);
		Assert.assertEquals(results.search(new BigDecimal("2")),4);
		Assert.assertEquals(results.search(new BigDecimal("3")),3);
		Assert.assertEquals(results.search(new BigDecimal("4")),2);
		Assert.assertEquals(results.search(new BigDecimal("5")),1);

		results = rpnProcessor.process("* * * *");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(120));
	}

	@Test
	public void testExample8() {
		Stack<BigDecimal> results = rpnProcessor.process("1 2 3 * 5 + * * 6 5");
		displayService.display(results);
		Assert.assertEquals(results.peek(),new BigDecimal(11));
	}
}
