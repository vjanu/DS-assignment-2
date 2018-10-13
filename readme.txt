Before running frontend it is important to run the backend services.

First execute FoodorderingApplication.java in foodordering service - localhost:8080

Next execute other additional backend services respectively....

DialogPaymentGatewayApplication.java in dialogdummyservice project  - localhost:8095
DrawApplication.java in drawdummyservice project  - localhost:8100
EmailApplication.java in emaildummyservice project  - localhost:8098
LoyaltyPointsApplication.java in loyaltypointsdummyservice project  - localhost:8099
SampathBankPaymentGatewayApplication.java in sampathbankdummyservice project  - localhost:8096
SMSApplication.java in smsdummyservice project  - localhost:8097

Note: After importing each and every service to your IDE, run a maven install to install all the dependencies.


After all the backend services up and running, execute the frontend service.
1)Import fastfoodappfrontend to any IDE capable of running angular 6.
2)Open a terminal and run 'npm install' command.
3)After installing all the dependencies, run 'ng serve'. It will open the Front end in the browser on port 4200.
4)After login screen prompts login with foolowing credentials
username - saman
password - 1231

If any 'Access-Control-Allow-Origin' error occurs, it is needed to install the particular cross origin extension to the browser and add the relevant url to it. Then the services can be accessible.

IT16030190
V.A.Wickramasinghe