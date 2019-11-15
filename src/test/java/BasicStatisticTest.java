import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BasicStatisticTest {
    private static String ERROR_MESSAGE;
    private static HashMap<Integer, String> testHashMap;
    BasicStatistic basicStatistic;

    int expectedResult;
    int unExpectedResult;
    int result;

    @BeforeClass
    public static void BeforeSetUp() throws Exception {
        ERROR_MESSAGE = "Something went wrong.";
        testHashMap = new HashMap<>();
    }

    @Before
    public void setUp() throws Exception {
        basicStatistic = new BasicStatistic();
    }
    @Test
    public void numberOfDataItemsShouldBeZeroWhenNoneIsPresent() {
        //arrange
        expectedResult = 0;

        //act
        result = basicStatistic.numberOfDataItems();

        //assert
        Assert.assertEquals(ERROR_MESSAGE, expectedResult,result);
    }
    @Test
    public void sumMethodShouldReturnZeroWhenNoneIsPresent(){
        //arrange
        Double expectedResult = 0.0;

        //act
        Double result = basicStatistic.sum();

        //assert
        Assert.assertEquals(ERROR_MESSAGE, expectedResult,result);
    }


    @Test
    public void AfterAddingDoubleNrOfItemsIsNotZero() {
        //arrange
        double value = 1.1;
        unExpectedResult = 0;
        //act
        basicStatistic.addDoubleToData(value);
        result = basicStatistic.numberOfDataItems();
        //assert
        Assert.assertNotEquals(ERROR_MESSAGE,unExpectedResult,result);
    }

    @Test
    public void AfterClearingDataNrOfItemsShouldBeZero() {
        //arrange
        double value = 1.1;
        basicStatistic.addDoubleToData(value);
        expectedResult = 0;
        //act
        basicStatistic.clearData();
        result = basicStatistic.numberOfDataItems();
        //assert
        Assert.assertEquals(ERROR_MESSAGE,expectedResult,result);
    }


    @Test
    public void sum() {
        //arrange
        Double value1 = 1.0;
        Double value2 = 1.1;
        Double expectedResult = 2.1;
        //act
        basicStatistic.addDoubleToData(value1);
        basicStatistic.addDoubleToData(value2);
        Double result = basicStatistic.sum();
        //assert
        Assert.assertEquals(ERROR_MESSAGE,expectedResult,result);
    }

    @Test
    public void ValuesAddedWithPutMethodShouldBeAvailableWithGetMethod() {
        //arrange
        int key = 1;
        String value = "Rabindra";
        String expectedValue = "Rabindra";
        //act
        testHashMap.put(key,value);
        String result = testHashMap.get(key);
        //assert
        Assert.assertEquals(ERROR_MESSAGE,expectedValue,result);
    }

    @Test
    public void AddingValueWithSameKeyShouldReplaceTheOldValue() {
        //arrange
        int key = 1;
        String value = "Rabindra";
        String newValue = "Riyansh";
        testHashMap.put(key,value);
        //act
        testHashMap.put(key,newValue);
        String result = testHashMap.get(key);
        //assert
        Assert.assertEquals(ERROR_MESSAGE,newValue,result);
    }

    @Test
    public void NullValueCanBeUsedAsKey() {
        //arrange
        String value = "Rabindra";
        //act
        testHashMap.put(null,value);
        String result = testHashMap.get(null);
        //assert
        Assert.assertEquals(ERROR_MESSAGE,value,result);
    }

}