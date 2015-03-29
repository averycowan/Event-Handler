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
