# Apple Interview 2020

## First Problem

----
Find the running median play duration of stream of play events

Median is the middle element in a list of sorted numbers; if the size of
the list is even, then median is the average of middle two elements

Median Example : median of `[1,2,3]` is 2 and `[1,2,3,4]` is 2.5

Question - assume we have a stream of Apple Music track play events, and we need to find the
current median play duration, at each point in the stream


### Example Inputs:

    {
     "eventId": "9e20342f-0477-407b-98b7-90a2c319af4a",
     "trackId": "b2997a71-bb50-43cb-b254-8ace7c5fc5ba",
     "startedAt": 1591009200000,
     "endedAt": 1591009470000
    }
    
    {
     "eventId": "f2f217a6-7ccf-4420-a117-7dd8757294fb",
     "trackId": "ce3f9080-598e-46b6-b4f0-5a5a7a494ac6",
     "startedAt": 1591009410000,
     "endedAt": 1591009470000
    }
    
    {
     "eventId": "97f8f849-3d65-43d7-a8f1-721723665400",
     "trackId": "ce3f9080-598e-46b6-b4f0-5a5a7a494ac6",
     "startedAt": 1591009380000,
     "endedAt": 1591009470000
    }
    
    {
     "eventId": "fdfbc1c8-05e4-46f1-a1bc-40e1cdb6d87f",
     "trackId": "b2997a71-bb50-43cb-b254-8ace7c5fc5ba",
     "startedAt": 1591009410000,
     "endedAt": 1591009475000
    }

### Expected Outputs:

    1st Call:
       durations = [270_000ms]
       so median duration = 270_000ms (4 minutes, 30 seconds)
    2nd Call:
       durations = [270_000ms, 60000ms]
       so median duration = 165_000ms (2 minutes, 45 seconds)
    3rd Call:
       durations = [270_000ms, 60000ms, 90000ms]
       so median duration = 90000ms (1 minutes, 30 seconds)
    4th Call:
       durations = [270_000ms, 60000ms, 90000ms, 65000ms]
       so median duration = 77500ms (~1 minutes, 14 seconds)

### How to run tests

    ./gradlew test --rerun-tasks

