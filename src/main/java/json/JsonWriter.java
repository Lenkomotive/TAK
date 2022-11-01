package json;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class JsonWriter {
    private static final Logger logger = LogManager.getLogger(JsonWriter.class);

    private static final String PATH = "src/main/java/json/game_state.json";

    public static void writeGameStateToJSON(Tak.GameState state) {
        JsonObjectBuilder json = Json.createObjectBuilder()
                .add("board_length", state.getBoardLength())
                .add("remaining_capstones_white", state.getRemainingCapstonesList().get(0))
                .add("remaining_capstones_black", state.getRemainingCapstonesList().get(1))
                .add("remaining_stones_white", state.getRemainingStonesList().get(0))
                .add("remaining_stones_black", state.getRemainingStonesList().get(1));

        JsonArrayBuilder boardArray = Json.createArrayBuilder();
        int x = 0;
        int y = 0;
        for (Tak.Pile pile: state.getBoardList()) {
            JsonArrayBuilder pileArray = Json.createArrayBuilder();
            for(Tak.Piece piece: pile.getPiecesList()) {
                JsonObjectBuilder pieceBuilder = Json.createObjectBuilder();
                pieceBuilder
                        .add("x", x)
                        .add("y", y)
                        .add("piece_type", piece.getTypeValue())
                        .add("second_player_owned", piece.getSecondPlayerOwned());
                pileArray.add(pieceBuilder);
            }
            x++;
            if(x == state.getBoardLength()) {
                x = 0;
                y++;
            }
            boardArray.add(pileArray);
        }
        json.add("board", boardArray);
        writeJSONToFile(json);
    }

    private static void writeJSONToFile(JsonObjectBuilder json) {
        try {
            FileWriter file = new FileWriter(PATH);
            file.write(prettyPrint(json.build().toString()));
            file.close();
        } catch (IOException e) {
            logger.error("Error while writing JSON");
        }
    }

    private static String prettyPrint(String json) {
        StringWriter sw = new StringWriter();
        try {
            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = jsonReader.readObject();

            Map<String, Object> properties = new HashMap<>(1);
            properties.put(JsonGenerator.PRETTY_PRINTING, true);

            JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
            javax.json.JsonWriter jsonWriter = writerFactory.createWriter(sw);
            jsonWriter.writeObject(jsonObject);
            jsonWriter.close();
        } catch (Exception e) {
            logger.error("Error while formatting JSON");
        }
        return sw.toString();
    }
}
