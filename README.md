# Dapeng.DataHubService

## Problem Background
    As a programmer with a fascination for stock markets, you got excited about a new data set that you discovered
    that there is a collection of records from the [Dow Jones Index from 2011](http://archive.ics.uci.edu/ml/datasets/Dow+Jones+Index#) that caught your attention. 

    You decided you'd like to build an application server (Spring Boot or NodeJS) that would allow multiple users to perform the following operations concurrently:
        - upload a bulk data set
        - query for data by stock ticker (e.g. input: AA, would return 12 elements if the only data uploaded were the single data set above)
        - add a new record
