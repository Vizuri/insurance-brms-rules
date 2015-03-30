[when]If property age is {var} or more but less than {var1}= $property : Propety(getAge() >= {var}, getAge() < {var1})
[then] Set property risk rate to {var}= System.out.println("***** Property Age: " + getAge());
                                                                                $property.setRiskRate({var});
                                                                                update ($property);
                                                                                