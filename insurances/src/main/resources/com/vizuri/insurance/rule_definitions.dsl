[when]If property age is {var} or more but less than {var1}= $property : Property(getAge() >= {var}, getAge() < {var1})
[when]If we have a quote = $quote : Quote(id != null)

[then] Set quote risk rate to {var}= System.out.println("***** Quote Risk Rate set based on property Age: " + $property.getAge());
                                                                                $quote.setRiskRate({var});
                                                                                update ($quote);
                                                                                