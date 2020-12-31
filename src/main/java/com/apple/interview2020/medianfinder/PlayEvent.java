package com.apple.interview2020.medianfinder;

public class PlayEvent {

    private String eventId;    // UUID - e.g. "f9f2c9af-385f-4091-8cec-0f291e77574d"
    private String trackId;    // UUID - e.g. "77625a78-a595-4fae-a253-9992a6b693f9"
    private Long startedAt;    // Milliseconds since epoch - e.g. 1591009200000 (Mon, 01 Jun 2020 11:00:00 GMT)
    private Long endedAt;      // Milliseconds since epoch - e.g. 1591009470000 (Mon, 01 Jun 2020 11:04:30 GMT)

    public PlayEvent(String eventId, String trackId, Long startedAt, Long endedAt) {
        this.eventId = eventId;
        this.trackId = trackId;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public String getEventId() {
        return eventId;
    }

    public String gettrackId() {
        return trackId;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public Long getEndedAt() {
        return endedAt;
    }

    public Long getDuration() {
        return endedAt - startedAt;
    }
}
