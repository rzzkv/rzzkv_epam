# Test Automation Framework

## Configuration Options

### Browser Options

You can choose from the following web browsers for testing:
- `chrome`
- `firefox`

### Environments

You can select one of the following environments:
- `dev`
- `test`

### Test Suite Files

There are two test suite files available:
- `testing-all.xml` (Comprehensive Test Suite)
- `testing-smoke.xml` (Smoke Test Suite)

## Running Tests


To run  tests, use the following command in the terminal:
```bash
gradle test -Pbrowser=<BROWSER> -Penvironment=<ENVIRONMENT> -Dsurefire.suiteXmlFiles=src/test/resources/suits/<SUITE_XML_FILE>
```
Example:
```bash
gradle test -Pbrowser=chrome -Penvironment=test -Dsurefire.suiteXmlFiles=src/test/resources/suits/testng-all.xml
```
