package annotator.model.statistics;

import annotator.model.vote.Vote;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

@XStreamAlias("PackageStatistics")
public class PackageStatistics {

    private final Double averagePackageDuration;
    private final Double trueRatio;

    public PackageStatistics(List<Vote> voteList) {
        this.averagePackageDuration = voteList.stream().mapToLong(Vote::getDuration).average().getAsDouble();
        this.trueRatio = ((Long) voteList.stream()
                    .filter(Vote::getBelongsToType)
                    .count())
                .doubleValue() / voteList.size();
    }

    public Double getAveragePackageDuration() {
        return averagePackageDuration;
    }

    public Double getTrueRatio() {
        return trueRatio;
    }
}