/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package view;

public class MainLoop implements Runnable
{
    public static final int DEFAULT_UPS = 80;
    public static final int DEFAULT_NO_DELAYS_PER_YIELD = 16;
    public static final int DEFAULT_MAX_FRAME_SKIPS = 5;

    private LoopSteps game;
    private long desiredUpdateTime;
    private boolean running;

    private long afterTime;
    private long beforeTime = System.currentTimeMillis();

    private long overSleepTime = 0;
    private long excessTime = 0;

    private int noDelaysPerYield = DEFAULT_NO_DELAYS_PER_YIELD;
    private int maxFrameSkips = DEFAULT_MAX_FRAME_SKIPS;

    int noDelays = 0;    

    public MainLoop(LoopSteps loopSteps,
            int ups,
            int maxFrameSkips,
            int noDelaysPerYield)
    {
        super();

        if (ups < 1)
            throw new IllegalArgumentException("Voc� deve exibir, pelo menos, um quadro por segundo!");

        if (ups > 1000)
            ups = 1000;

        this.game = loopSteps;
        this.desiredUpdateTime = 1000000000L / ups;
        this.running = true;

        this.maxFrameSkips = maxFrameSkips;
        this.noDelaysPerYield = noDelaysPerYield;
    }

    public MainLoop(LoopSteps loopSteps, int ups)
    {
        this(loopSteps, ups, DEFAULT_MAX_FRAME_SKIPS, DEFAULT_NO_DELAYS_PER_YIELD);
    }
    
    public MainLoop(LoopSteps loopSteps)
    {
        this(loopSteps, DEFAULT_UPS);
    }

    private void sleep(long nanos) throws InterruptedException
    {
        noDelays = 0;
        long beforeSleep = System.nanoTime();
        Thread.sleep(nanos / 1000000L, (int) (nanos % 1000000L));
        overSleepTime = System.nanoTime() - beforeSleep - nanos;
    }

    private void yieldIfNeed()
    {
        if (++noDelays == noDelaysPerYield)
        {
            Thread.yield();
            noDelays = 0;
        }
    }

    private long calculateSleepTime()
    {
        return desiredUpdateTime - (afterTime - beforeTime) - overSleepTime;
    }

    public void run()
    {
        running = true;
        try
        {
            game.setup();
            while (running)
            {
                beforeTime = System.nanoTime();
                skipFramesInExcessTime();
    
                game.processLogics();
                game.renderGraphics();
                game.paintScreen();
                afterTime = System.nanoTime();
    
                long sleepTime = calculateSleepTime();
    
                if (sleepTime >= 0)
                    sleep(sleepTime);
                else
                {
                    excessTime -= sleepTime; 
                    overSleepTime = 0L;
                    yieldIfNeed();
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception during game loop", e);
        }
        finally
        {
            running = false;
            game.tearDown();
//            System.exit(0);
        }
    }

    private void skipFramesInExcessTime()
    {
        int skips = 0;
        while ((excessTime > desiredUpdateTime) && (skips < maxFrameSkips))
        {
            excessTime -= desiredUpdateTime;
            game.processLogics();
            skips++;
        }
    }

    public void stop()
    {
        running = false;
    }
}
