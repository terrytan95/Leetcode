import unittest
import Solution as solution

class NaiveBayesTest(unittest.TestCase):

    def test1(self):
        # load_data()
        test = solution
        # classifier.train(data[:12478])
        # predictions = classifier.classify(data[12478:])
        # fp, fn = f_score(data[12478:],predictions)
        # print(fp, fn)
        # self.assertGreater(fp,0.90)
        # self.assertGreater(fn,0.60)
        store = [1,5,20,11,16]
        house = [5,10,17]
        result = classifier.store(store, house)
        print(result)


if __name__ == "__main__":

    unittest.main()
