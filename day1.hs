import System.IO

main :: IO ()
main = do
  file <- readFile "testdata.txt" 
  let solution1 = (show . solve  . parse . lines) file 
      solution2 = (show . solve' . parse . lines) file
  putStrLn $ "Solution 1: " ++ solution1
  putStrLn $ "Solution 2: " ++ solution2

    
solve :: [Integer] -> Integer
solve = sum . map simplMass

solve' :: [Integer] -> Integer
solve' = sum . map (\x -> recMass $ simplMass x)
  where
    recMass :: Integer -> Integer
    recMass val | val > 0   = val + (recMass $ simplMass val) 
    recMass val | otherwise = 0

simplMass :: Integer -> Integer
simplMass x = (x `div` 3) - 2

parse :: [String] -> [Integer]
parse = map read

