package json;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import tak.Tak;
import utils.PieceColor;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class JSONWriter {
    private static final Logger logger = LogManager.getLogger(JSONWriter.class);

    private static final String PATH = "src/main/java/json/games/game_state.json";

    public static void writeGameStateToJSON(Tak.GameState state, String path, boolean beginningPlayer) {
        PieceColor ourColor = beginningPlayer? PieceColor.WHITE:PieceColor.BLACK;
        PieceColor opponentColor = beginningPlayer? PieceColor.BLACK: PieceColor.WHITE;
        JsonObjectBuilder json = Json.createObjectBuilder()
                .add("our_piece_color", ourColor.ordinal())
                .add("opponent_piece_color", opponentColor.ordinal())
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
            int position = 0;
            for(Tak.Piece piece: pile.getPiecesList()) {
                PieceColor color = piece.getSecondPlayerOwned()? opponentColor : ourColor;
                JsonObjectBuilder pieceBuilder = Json.createObjectBuilder();
                pieceBuilder
                        .add("x", x)
                        .add("y", y)
                        .add("position_in_pile", position)
                        .add("piece_type", piece.getTypeValue())
                        .add("piece_color", color.ordinal());
                pileArray.add(pieceBuilder);
                position++;
            }
            x++;
            if(x == state.getBoardLength()) {
                x = 0;
                y++;
            }
            boardArray.add(pileArray);
        }
        json.add("board", boardArray);
        writeJSONToFile(json, path);
    }

    private static void writeJSONToFile(JsonObjectBuilder json, String path) {
        try {
            FileWriter file = new FileWriter(path);
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

     public static String createFolderForGameStates(String pathToFolder) throws IOException {
         long count = Files.find(Paths.get(pathToFolder),1,
                 (path, attributes) -> attributes.isDirectory()
         ).count() - 1;
         String folderName = "game_" + count;
         Files.createDirectories(Paths.get(pathToFolder + folderName));
         return folderName;
     }
}
