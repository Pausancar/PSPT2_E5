package es.studium.PrRunnable;

public class PrRunnable implements Runnable
{
	static Thread hilo1;
	public static void main(String[] args)
	{
		PrRunnable objetoPrRunnable = new PrRunnable();
		 hilo1 = new Thread(objetoPrRunnable,"Hilo");
		 hilo1.start();
	}

	@Override
	public void run()
	{
		boolean sigue=true;
		for(int i=0;i<100 & sigue;i++)
		{
			System.out.println(Thread.currentThread().getName()+": "+ i);
			try {
				Thread.sleep(500);
				if (i==2)
				{
					hilo1.interrupt();
				}
			} catch (InterruptedException e) {
				sigue=false;
				System.out.println("El hilo ha sido interrumpido");
			}
		}
	}

}
