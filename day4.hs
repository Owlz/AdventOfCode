import Data.List
import Data.Char
import Debug.Trace

main :: IO ()
main = do
  file <- readFile "input4.txt"
  let solution1 = (show . solve  . parse) file
      solution2 = (show . solve' . parse) file
  putStrLn $ "Solution 1: " ++ solution1
  putStrLn $ "Solution 2: " ++ solution2
    
solve :: [Int] -> Int
solve bs = length . filter (\x -> length x == 6 && hasAtLeastDouble x && isIncreasing x) $ map show [head bs ..bs !! 1] 

solve' :: [Int] -> Int
solve' bs = length . filter (\x -> length x == 6 && hasDouble x && isIncreasing x) $ map show [head bs ..bs !! 1] 

hasDouble :: String -> Bool
hasDouble s = any (\x -> length x == 2) $ group s

hasAtLeastDouble :: String -> Bool
hasAtLeastDouble s = any (\x -> length x >= 2) $ group s

isIncreasing :: String -> Bool
isIncreasing (x:y:xs) = if(digitToInt x <= digitToInt y) then isIncreasing $ y:xs else False
isIncreasing (x:[]) = True
isIncreasing [] = True

parse :: String -> [Int]
parse = map read . split '-'

split :: Char -> String -> [String]
split x [] = [""]
split x (c:cs)
  | c == x  = "" : rest
  | otherwise = (c : head rest) : tail rest
    where rest = split x cs
