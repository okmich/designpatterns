# Fighter Jets' missiles
##Implementation of a Strategy Design pattern.

Scenario:: Two fighter jets that can fire and reload several kinds of missiles. The missiles will be loaded for fire at runtime and as such is decoupled from the design of the jet.
 
An addition was later made to trigger an error should a missile be deployed on the wrong jet. In real life, the is passing an implementation that is not meant for a certain strategy... At a higher level of design, it could be prevented by doing lower level interface declaration but a much lower level, we are using event to trigger a deployment error.
