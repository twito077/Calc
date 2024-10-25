package demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAddOne(){
        Calculator sut = new Calculator();
        sut.add(1);
        assertEquals("0+1 = 1", 1, sut.getState());
    }

    @Test
    public void testMultOneByTwo(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        assertEquals("1*2 = 2", 2, sut.getState());
    }

    @Test
    public void testAddNegative(){
        Calculator sut = new Calculator();
        sut.add(-1);
        assertEquals("0+(-1) = -1", -1, sut.getState());
    }

    @Test
    public void testAddZero(){
        Calculator sut = new Calculator();
        sut.add(0);
        assertEquals("0+0 = 0", 0, sut.getState());
    }

    @Test
    public void testMultByZero(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.mult(0);
        assertEquals("5*0 = 0", 0, sut.getState());
    }

    @Test
    public void testSubtractOne(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.subtract(1);
        assertEquals("5-1 = 4", 4, sut.getState());
    }

    @Test
    public void testSubtractNegative(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.subtract(-1);
        assertEquals("5-(-1) = 6", 6, sut.getState());
    }

    @Test
    public void testSubtractZero(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.subtract(0);
        assertEquals("5-0 = 5", 5, sut.getState());
    }

    @Test
    public void testDivideByTwo(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(2);
        assertEquals("10/2 = 5", 5, sut.getState());
    }

    @Test
    public void testDivideByNegative(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(-2);
        assertEquals("10/(-2) = -5", -5, sut.getState());
    }

    @Test
    public void testDivideByOne(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(1);
        assertEquals("10/1 = 10", 10, sut.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero(){
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0);
    }

    @Test
    public void testStoreInMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(0);
        sut.addFromMemory();
        assertEquals("Stored 10 in memory and added to state", 10, sut.getState());
    }

    @Test
    public void testAddFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(5);
        sut.addFromMemory();
        assertEquals("5 + 10 = 15", 15, sut.getState());
    }

    @Test
    public void testSubtractFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(20);
        sut.subtractFromMemory();
        assertEquals("20 - 10 = 10", 10, sut.getState());
    }

    @Test
    public void testMultFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(2);
        sut.multFromMemory();
        assertEquals("2 * 10 = 20", 20, sut.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideFromMemoryByZero() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(20);
        sut.setState(0);
        sut.divideFromMemory(); // This should throw IllegalArgumentException
}

    @Test
    public void testDivideFromMemory() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.storeInMemory();
        sut.setState(20);
        sut.divideFromMemory();
        assertEquals("20 / 10 = 2", 2, sut.getState());
    }
}