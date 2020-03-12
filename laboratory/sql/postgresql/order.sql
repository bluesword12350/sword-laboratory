SELECT * FROM (VALUES ('Unaudited'), ('Published'),('Invalid')) AS t (state)
order by
    case state
        when 'Unaudited' then 1
        when 'Published' then 0
        when 'Invalid' then 2
    end desc