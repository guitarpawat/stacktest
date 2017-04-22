package ku.util;

import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assume.*;
import java.util.EmptyStackException;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class StackTest {
    
    private Stack<Integer> stack = null;
    private Integer one = new Integer(1);
    private Integer two = new Integer(2);
    private Integer three = new Integer(3);
    private Integer four = new Integer(4);
    private Integer five = new Integer(5);
    

    @After
    public void clearStack() {
        stack = null;
    }
    
    @Test
    public void testNormalEmptyCase() {
        stack = makeStack(3);
        assumeNotNull(stack);
        assertEquals("Size of empty stack must be 0",0,stack.size());
        assertEquals("Invalid capacity of stack",3,stack.capacity());
        assertTrue("isEmpty of size=0 stack must be true",stack.isEmpty());
        assertFalse("isFull must be false when size=0 and capacity=3",stack.isFull());
        assertNull("Empty stack must be return null when peek",stack.peek());
    }
    
    @Test(expected = EmptyStackException.class)
    public void testEmptyStackException() {
        stack = makeStack(3);
        stack.push(one);
        stack.pop();
        stack.pop();
    }
    
    @Test(expected = EmptyStackException.class)
    public void testEmptyStackException0() {
        stack = makeStack(0);
        stack.pop();
    }
    
    @Test
    public void testEmptyStack() {
        stack = makeStack(0);
        assumeNotNull(stack);
        assertEquals("Size of empty stack must be 0",0,stack.size());
        assertEquals("Invalid capacity of stack",0,stack.capacity());
        assertTrue("isEmpty when size=0 stack must be true",stack.isEmpty());
        assertTrue("isFull when size=0 stack must be true",stack.isFull());
        assertNull("Empty stack must be return null when peek",stack.peek());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testIllegalStateExceptionSize0() {
        stack = makeStack(0);
        stack.push(new Integer(2));
    }
    
    @Test(expected = IllegalStateException.class)
    public void testIllegalStateException() {
        stack = makeStack(1);
        stack.push(new Integer(4));
        stack.push(new Integer(2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentException() {
        stack = makeStack(2);
        stack.push(null);
    }
    
    @Test
    public void testPeek() {
        stack = makeStack(3);
        stack.push(one);
        assertSame("Peek not returning same object",one,stack.peek());
        assertEquals("Peek must not remove the object",1,stack.size());
        stack.push(two);
        assertSame("Peek not returning the top object",two,stack.peek());
        assertSame("Peek not returning the top object",two,stack.peek());
        assertSame("Peek not returning the top object",two,stack.peek());
        assertEquals("Peek must not change the capacity",3,stack.capacity());
    }
    
    @Test
    public void testPop() {
        stack = makeStack(3);
        stack.push(one);
        assertSame("Peek not returning same object",one,stack.pop());
        assertEquals("Peek must remove the object",0,stack.size());
        stack.push(two);
        stack.push(three);
        assertSame("This stack size is invalid",2,stack.size());
        stack.push(four);
        assertSame("Peek not returning the top object",four,stack.pop());
        assertEquals("Peek must remove the object",2,stack.size());
        assertEquals("Peek must not change the capacity",3,stack.capacity());
    }
    
    @Test
    public void testPush() {
        stack = makeStack(5);
        stack.push(one);
        assertEquals("Invalid size of stack after push",1,stack.size());
        stack.push(two);
        stack.push(three);
        stack.push(four);
        stack.push(five);
        assertEquals("Invalid size of stack after push",5,stack.size());
    }
    
    @Test
    public void testSize() {
        stack = makeStack(3);
        assertEquals("Invalid start size",0,stack.size());
    }
    
    @Test
    public void testIsFull() {
        stack = makeStack(3);
        stack.push(one);
        assertFalse("This stack is not full now",stack.isFull());
        stack.push(two);
        stack.push(three);
        assertTrue("This stack is full now",stack.isFull());
        stack.pop();
        assertFalse("This stack is not full now",stack.isFull());
        stack.push(four);
        assertTrue("This stack is full now",stack.isFull());
    }
    
    @Test
    public void testIsEmpty() {
        stack = makeStack(2);
        assertTrue("This stack is empty now",stack.isEmpty());
        stack.push(one);
        assertFalse("This stack is not empty now",stack.isEmpty());
        stack.pop();
        assertTrue("This stack is empty now",stack.isEmpty());
        stack.push(two);
        assertFalse("This stack is not empty now",stack.isEmpty());
        stack.push(three);
        assertFalse("This stack is not empty now",stack.isEmpty());
    }
    
    @Test
    public void testCapacity() {
        stack = makeStack(3);
        assertEquals("Invalid start capacity",3,stack.capacity());
        stack.push(one);
        stack.push(two);
        assertEquals("Invalid capacity",3,stack.capacity());
        stack.pop();
        assertEquals("Invalid capacity",3,stack.capacity());
        stack.push(three);
        stack.push(four);
        assertEquals("Invalid capacity",3,stack.capacity());
        stack.pop();
        assertEquals("Invalid capacity",3,stack.capacity());
        stack.pop();
        assertEquals("Invalid capacity",3,stack.capacity());
    }
    
    private Stack makeStack(int max) {
        StackFactory.setStackType(1);
        return (Stack<Integer>)StackFactory.makeStack(max);
//        Stack<Integer> dummy = new Stack() {
//            int capacity = max;
//            int size = 0;
//            
//            @Override
//            public Object pop() {
//                if(size == 0) throw new EmptyStackException();
//                size--;
//                return null;
//            }
//
//            @Override
//            public Object peek() {
//                return null;
//            }
//
//            @Override
//            public void push(Object obj) {
//                if(isFull()) throw new IllegalStateException();
//                size++;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return size == 0;
//            }
//
//            @Override
//            public boolean isFull() {
//                return size == capacity;
//            }
//
//            @Override
//            public int capacity() {
//                return capacity;
//            }
//
//            @Override
//            public int size() {
//                return size;
//            }
//        };
//        return dummy;
    }
}