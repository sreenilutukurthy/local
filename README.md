# Digital skills DVLA test

### How to run the test

Tests load test data from "src/test/java/com/digitalskills/dvla/test-data" folder. Once data is added, execute the command below from terminal. 

```
mvn verify
```

## Assumptions

* All excel files contains vehicle registration details in required format
* Currently any number of XLSX format files are supported, but can be extended to XLS and CSV with minor enhancements
* Data format validation upon reading the file is not being done but can be added as future development

