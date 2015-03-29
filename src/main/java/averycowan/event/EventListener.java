package averycowan.event;
/**
 * Extend this class when making an event listener.
 * Register an <code>EventListener</code> with <code>EventManager.addListener(EventListener listener);</code>.
 * This can be a standard class or an anonymous inner class as long as <code>onEvent()</code> and <code>getEventType()</code> are implemented.
 * 
 * @author Avery Cowan
 * @see averycowan.event.EventManager
 */
public abstract class EventListener implements java.util.EventListener{
	protected Event event;
	/**
	 * This tells the <code>EventManager</code> what type of event the <code>EventListener</code> is listening for.
	 * @return a Class object representing the <code>Event</code> this represents.
	 */
	public abstract Class<?> getEventType();
	
	/**
	 * Once registered, this is the method that will run when the desired <code>Event</code> occours.
	 */
	protected abstract void onEvent();
	
	/**
	 * Runtime magic. Do not touch.
	 *  @param e the event to pass.
	 *  @return whether the <code>Event</code> was passed.
	 *  @throws ClassCastException if e is not the right type.
	 */
	public final boolean eventTriggered(Event e){
		if(!getEventType().isInstance(e))
			throw new ClassCastException("From "+e.getClass().toString()+" to "+getEventType().toString());
		event = e;
		EventListener l = this;
		new Thread() {
			public void run(){
				l.onEvent();
			}
		}.start();
		return true;
	}
}
