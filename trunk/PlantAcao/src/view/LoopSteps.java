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
/**
 * This interface provide the methods executed in each step of a main loop. Each
 * step, the game process its logics and, if the frame rate are adequate, paint
 * it's screen.
 */
public interface LoopSteps
{
    /**
     * This event occurs before the first iteration of the loop, and only once.
     */
    void setup();

    /**
     * The processLogics method updates all game object states. The game will
     * process it's data model and define the next game situation that will be
     * painted on the screen.
     */
    void processLogics();

    /**
     * Renders the next actual game situation in a buffer, for future painting.
     */
    void renderGraphics();

    /**
     * Paints the rendered graphics in the screen.
     */
    void paintScreen();

    /**
     * Called when the game loop ended.
     */
    void tearDown();
}
