//[when]If property age is {var} or more but less than {var1}= $property : Property(getAge() >= {var}, getAge() < {var1}, getRiskRate() == 0)
[when]If property age is {var} or more but less than {var1}= $property : Property(getAge() >= {var}, getAge() < {var1}, getRiskRate() == 0)
									
[then] Set property risk rate to {var}= System.out.println("***** Property Age: " + $property.getAge());
                                                                                $property.setRiskRate({var});
                                                                                update ($property);

[then] Set quote risk rate to {var}= System.out.println("***** Quote Risk Rate: " + $property.getAge());
                                                                                $property.setRiskRate({var});
                                                                                update ($property);
                                                                                