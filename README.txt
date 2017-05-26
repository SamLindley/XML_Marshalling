Hello!

To run this jar file simply navigate to the containing folder in a command prompt and type:

java -jar XML_Marshalling.jar


COMMENTS:

#I left everything in the generated Classes alone, as I thought that was probably best practice. (I can't know what
hypothetical compatibility issues or requirements you might have)

#Despite this, I would have liked to do minor refactoring. CamelCasing Shiporder would make me happy! Adding some methods
and maybe separating out the static classes are also things I would have considered.

#I made the OrderList class to act as a wrapper to enable the generation of one long XML file instead of multiple ones
for multiple orders, if desired.

#I'm quite please with how I separated responsibilities in the service classes, but can't help but feel that
ShiporderService shouldn't really have the ability to print to the console directly. I thought about adding a layer of
abstraction and having a printer interface but then thought "You are over-complicating things". KISS!

