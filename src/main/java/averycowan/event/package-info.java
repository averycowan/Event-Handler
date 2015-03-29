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

/**
 * This project does dynamic event handling and listener management in the runtime. This removes the need for a different handler for each exception. Just make the events and listener, and it does the rest.
 * 
 * The first step is to create your <code>Event</code> implementation. Lets call this <code>CustomEvent</code>.
 * Next, create an extension to <code>EventListener</code> for your Event.
 * Call <code>EventManager.addListener(EventListener listener);</code> with your custom <code>EventListener</code>.
 * When there is an event, call <code>EventManager.handleEvent(new CustomEvent(?????));</code> from the event source and you listener will get it.
 * @author Avery Cowan
 * @see averycowan.event.EventManager
 */
package averycowan.event;