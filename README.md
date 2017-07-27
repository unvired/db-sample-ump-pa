# db-sample-ump-pa
The UMP Process Agent project for Database sample

1) Please go through this link: https://marketplace.eclipse.org/content/unvired-modeler-and-chyme-bots-builder-ump-v4
   You'll will get to know which Eclipse Versions are supportable with existing latest version of Unvired Modeler/Designer. Install     Eclipse in your system and drag and drop latest designer plugin from the same link.
2) Go through Unvired App Development Guide: https://unvired.atlassian.net/wiki/display/UNVIRED/Build+Unvired+Applications#BuildUnviredApplications-Attachments
3) Once Eclipse Setup is done and Unvired Designer Plugin installed. Follow below steps:
   Project Explorer -> File -> New Workspace -> Right Click on Project Explorer -> Import -> Projects from Git -> Select Repository        Source as Clone URI -> Enter the location of the source repository -> Next -> Select master -> Next -> Configure the local storage      location for db-sample-ump-pa -> Browse the location of Workspace and provide File Name same as .unvapp file name as in source          repository -> Next -> Import using the New Project wizard -> Finish -> Java Project -> Next -> Project Name must be same as .unvapp      file name as in source repository -> Next -> Finish -> Double click on .unvapp file -> Click on button " Check for SDK Updates" at      top right corner.
4) Go through different tabs/options available one by one.
   a) Application Tab 
        - Will provide details like Application Name, Description, Version, Build No, Vendor, Package Name and Data Format.
   b) Landscape Tab 
        - Will show the list of Supported Devices and Systems. 
        - Add/Delete System as per requirements. Here we added "MY SQL DB" 
        - Select System added and set required properties and click on "Test Connection".
        - If test connection succeeded. Search for Schema and Tables. 
        - Add Table/Procedure
        - Mark in Check Box besides Tables that you added and click on Generate and Save.
        - Click on "Generate and Deploy" option to generate proxy classes and other required source classes.
        - Generate will provide 2 options one to generate source code that I mentioned above. Also you can generate jar file to deploy             in UMP Server.
        - Deploy Applications - Needed at the end when all the properties set properly, Business Entities, Functions added, Required               logics implemented.
    c) Business Entities Tab
        - Create Entity manually or you can also use "Explore Services" option available. Where you can select System, Function and               Type.
        - Select Database, Tables and required Fields that you want to add in Entity. 
        - Use options available like "Map Header", "Map Item" and "Map Field".
    d) Functions Tab
        - Create/Define your own Functions like for example here we have "GET_CONTACTS" and "CREATE_CONTACT".
        - Add Input and Output Table needed for each Functions.
        - Add Interface
        - Map Entity that you added/created with one available in Backend.
        - Save and use options available in Landscape Tab to "Generate & Deploy". 
    e) Test Tab
        - Once Code and Jar generated deploy it to UMP Server.
        - For deployment to UMP you need Developer User credentials.
        - For local testing of PA Functions we need to set Application User, Auth Token and Device Id belongs to the UMP Server where             jar file is deployed.
