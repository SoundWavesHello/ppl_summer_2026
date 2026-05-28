class MoreComplicatedExampleTest extends org.scalatest.funsuite.AnyFunSuite {


    test("I can create an absurdly complicated polymorphic variable"){
        // Comment in once traits/classes/objects are implemented
        val j0: Juliette = Oscar(Yankee, 
                         Sierra(Oscar(Yankee, 
                                      Sierra(Oscar(Yankee, 
                                                   Sierra(Oscar(Yankee, 
                                                                Sierra(Xray))))))))
    }

}