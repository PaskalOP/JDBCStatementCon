SELECT
    project.id AS project_id,
    SUM(worker.selary * project.MONTH_COUNT) AS price
FROM
    project, project_worker, worker
WHERE
    project.id = project_worker.project_id
    AND project_worker.worker_id = worker.id
GROUP BY
    project.id
ORDER BY
    price DESC;