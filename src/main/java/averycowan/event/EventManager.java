/*
 * Copyright 2015 Avery Cowan.
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package averycowan.event;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class handles all events.
 * 
 * The first step is to create your <code>Event</code> implementation. Lets call this <code>CustomEvent</code>.
 * Next, create an extension to <code>EventListener</code> for your Event.
 * Call <code>addListener(EventListener listener);</code> with your custom <code>EventListener</code>.
 * When there is an event, call <code>EventManager.handleEvent(new CustomEvent(?????));</code> from the event source and you listener will get it.
 * 
 * @author Avery Cowan
 * @see averycowan.event.EventListener
 */
public abstract class EventManager {
	private static HashMap<Class<?>, ArrayList<EventListener>> listeners = new HashMap<Class<?>, ArrayList<EventListener>>();
	
	/**
	 * Registers an <code>EventListener</code>.
	 * @param listener this can be a standard class or an anonymous inner class.
	 */
	public static void addListener(EventListener listener){
		Class<?> c = listener.getEventType();
		if(listeners.get(c) == null)
			listeners.put(c, new ArrayList<EventListener>());
		listeners.get(c).add(listener);
	}
	
	/**
	 * Sends the event to registered <code>EventListeners</code> for this event type.
	 * @param event
	 */
	public static void handleEvent(Event event){
		System.out.println(event+"\n"+listeners);
		ArrayList<EventListener> ls = listeners.get(event.getClass());
		for(EventListener l : ls)
			l.eventTriggered(event);
	}
}
