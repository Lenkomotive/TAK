import algorithm.MinMax;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tak.Tak;
import utils.PieceColor;

public class PileControlTests {


    @Test
    void givenPileWithWhiteOnTop_whenOurMoveAndWeAreWhite_assertPileIsUnderOurControl() {
        boolean expected = true;
        boolean min = true;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(false).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();
        MinMax.ourColor = PieceColor.WHITE;

        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithWhiteOnTop_whenOurMoveAndWeAreBlack_assertPileIsNotUnderOurControl() {
        boolean expected = false;
        boolean min = true;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(false).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.BLACK;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithBlackOnTop_whenOurMoveAndWeAreWhite_assertPileIsNotUnderOurControl() {
        boolean expected = false;
        boolean min = true;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(true).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.WHITE;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithBlackOnTop_whenOurMoveAndWeAreBlack_assertPileIsUnderOurControl() {
        boolean expected = true;
        boolean min = true;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(true).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.BLACK;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    // opponents move
    @Test
    void givenPileWithWhiteOnTop_whenOpponentsMoveAndWeAreWhite_assertPileIsNotUnderOpponentsControl() {
        boolean expected = false;
        boolean min = false;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(false).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.WHITE;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithWhiteOnTop_whenOpponentsMoveAndWeAreBlack_assertPileIsUnderOpponentsControl() {
        boolean expected = true;
        boolean min = false;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(false).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.BLACK;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithBlackOnTop_whenOpponentsMoveAndWeAreWhite_assertPileIsUnderOpponentsControl() {
        boolean expected = true;
        boolean min = false;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(true).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.WHITE;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

    @Test
    void givenPileWithBlackOnTop_whenOpponentsMoveAndWeAreBlack_assertPileIsNotUnderOpponentsControl() {
        boolean expected = false;
        boolean min = false;
        Tak.Piece piece = Tak.Piece.newBuilder().setSecondPlayerOwned(true).build();
        Tak.Pile pile = Tak.Pile.newBuilder().addPieces(piece).build();

        MinMax.ourColor = PieceColor.BLACK;
        boolean result = MinMax.pileIsUnderControl(pile, min);

        Assert.assertEquals(expected, result);
    }

}
