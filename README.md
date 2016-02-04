# insurance-brms-rules
Rules components for BRMS Insurance demonstration

Go to https://github.com/Vizuri/insurance-brms-code.git for on how to run the example.

## Please note the different library dependency versions in the pom.xml, depending on whether you want to use BRMS 6.1.x or 6.2.0	 

    * BRMS 6.1.x
        * Use version: 6.0.3-redhat-6 for BRMS 6.1.x
          
    * BRMS 6.2
        * Use version: 6.3.0.Final-redhat-5 for BRMS 6.2
        
    * Please note that a similar change has to be made in the web app project depending on which version of BRMS you are running. Notes were added to the pom of the rules project to indicate which changes to make.
    
    * Open the pom.xml and verify that the correct dependencies are selected for the given version of BRMS
       
        * BRMS 6.1.x
            * Use version: 6.0.3-redhat-6 for BRMS 6.1.x
          
        * BRMS 6.2
            * Use version: 6.3.0.Final-redhat-5 for BRMS 6.2
