[when]If property age is {var} or more but less than {var1}= $property : Property(getAge() >= {var}, getAge() < {var1})
[when]If we have a quote = $quote : Quote()
									
[then] Set property risk rate to {var}= System.out.println("***** Property Age: " + $property.getAge());
                                                                                $property.setRiskRate({var});
                                                                                update ($property);

[then] Set quote risk rate to {var}= System.out.println("***** Quote Risk Rate: " + $property.getAge());
                                                                                $quote.setRiskRate({var});
                                                                                update ($quote);
                                                                                