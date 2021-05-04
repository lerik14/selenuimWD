# selenuimWD

## Run tests
- Open a terminal or command prompt
- Go to {PROJECT_ROOT}
- Execute `mvn clean test` to run tests

### Connect Appium
- Open Appium server `http://0.0.0.0:4723`
- Deliver calculator app to simulator 
- Connect simulated android device to appium using next properties
  `deviceName, platformName, version, udid, appPackage, appActivity`
  
## Reporting
- Execute `mvn allure:report`
- Report generating to /target/site folder
- Run index.html from IDE to see the report
- Execute `mvn allure:serve` to open reprt in browser automatically
