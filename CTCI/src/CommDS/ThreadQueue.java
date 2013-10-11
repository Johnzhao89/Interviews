package CommDS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class ThreadQueue {

	Semaphore writeSemaphore = new Semaphore(1);
	Semaphore readSemaphore = new Semaphore(1);
	Queue <Integer> queue = new LinkedList();
	int size; 
	
	public ThreadQueue(int i) {
		size = i;
	}

	public void enqueue(int i)
	{
		try
		{
			writeSemaphore.acquire();
			while(queue.size() >= size)
			{
				synchronized(writeSemaphore)
				{
					writeSemaphore.wait();
				}
			}
			queue.offer(i);
			writeSemaphore.release();
			synchronized(readSemaphore)
			{
				readSemaphore.notify();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public int dequeue()
	{
		try
		{
			readSemaphore.acquire();
			while(queue.size() == 0)
			{
				synchronized(readSemaphore)
				{
					readSemaphore.wait();
				}
			}
			int item = queue.poll();
			readSemaphore.release();
			synchronized(writeSemaphore)
			{
				writeSemaphore.notify();
			}
			return item;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
}