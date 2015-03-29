# Event-Handler
An event handler that is given event types at runtime instead of at compile time. It does dynamic event handling and listener management in the runtime. This removes the need for a customized handler for each exception. Just make the events and listener, and it does the rest.

## Using Event-Handler
1. The first step is to create your `Event` implementation. Lets call this `CustomEvent`.

2. Next, create an extension to `EventListener` for your Event.

3. Call `EventManager.addListener(EventListener listener);` with your custom `EventListener`.

4. When there is an event, call `EventManager.handleEvent(new CustomEvent(?????));` from the event source and you listener will get it.

## How it works
The `EventManager` class maintains a `HashMap` of `Class` → `ArrayList<EventListener>`. This allows it to function at runtime without knowing the types of the events it will be handling on compile time.
