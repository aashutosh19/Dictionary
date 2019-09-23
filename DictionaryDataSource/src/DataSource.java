
public class DataSource {

    private Mapper<Keyword, Voice> mapper;
    private String definition;

    public DataSource(Mapper<Keyword, Voice> mapper, String definition) {
        this.mapper = mapper;
        this.definition = definition;
    }

    public Mapper<Keyword, Voice> getMapper() {
        return mapper;
    }

    public void setMapper(Mapper<Keyword, Voice> mapper) {
        this.mapper = mapper;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
